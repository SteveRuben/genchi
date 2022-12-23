import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../service/auth.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit{
  loginform: any;
  loading = false;
  submitted = false;
  prevUrl = '';
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {
    console.log(this.route.queryParams.subscribe((data)=>{
      console.log(data['returnUrl']); this.prevUrl=data['returnUrl'];
    }));
  }

  ngOnInit() {
    this.loginform = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginform.controls; }

  onSubmit() {
    this.submitted = true;
    if(this.loginform.invalid){
      return;
    }
    console.log(JSON.stringify(this.loginform.value));
    this.authService.login(this.loginform.value)
      .subscribe(() => {
        this.router.navigate([!!this.prevUrl? '/': this.prevUrl]).then(_ => console.log('You are secure now!'));
      }, (err: any) => {
        console.log(err);
      });
  }
}
