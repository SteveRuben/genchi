import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { TokenService } from './token.service';


const API_URL = 'http://localhost:6060/';
const RESOURCE_URL = 'http://localhost:7071/';


const HTTP_OPTIONS =  {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Headers':'*',
    'Access-Control-Allow-Methods':'*'
  })
};


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  redirectUrl: string | undefined;

  private static handleError(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }

  private static log(message: string): any {
    console.log(message);
  }
  constructor(private http: HttpClient, private tokenService: TokenService) { }

  login(loginData: any): Observable<any> {
    this.tokenService.removeToken();

    return this.http.post<any>(API_URL + 'login', JSON.stringify(loginData), HTTP_OPTIONS)
      .pipe(
        tap(res => {
          this.tokenService.saveToken(res.access_token);
        }),
        catchError(AuthService.handleError)
      );
  }



  logout(): void {
    this.tokenService.removeToken();
  }

  register(data: any): Observable<any> {
    return this.http.post<any>(API_URL + 'signup', data)
      .pipe(
        tap(_ => AuthService.log('register')),
        catchError(AuthService.handleError)
      );
  }

  secured(): Observable<any> {
    return this.http.get<any>(RESOURCE_URL + 'demo')
      .pipe(catchError(AuthService.handleError));
  }

}
