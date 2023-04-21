import { Component, OnInit } from '@angular/core';
import { UserService } from './UserService';
import { Employee } from './user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit {

  employees: Employee[];
  constructor(private userService: UserService) {
    this.employees = [];
  }


  ngOnInit(): void {
    console.log('hello');
    this.userService.getEmployees().subscribe((data: Employee[]) => {
      console.log(data);
      this.employees = data;
    });
  }

  

}

