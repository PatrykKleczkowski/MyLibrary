import { Component, OnInit } from '@angular/core';
import { User } from '@app/shared/model';
import { UserService } from '@app/shared/service/user.service';

@Component({
  selector: 'app-user-managment',
  templateUrl: './user-managment.component.html',
  styleUrls: ['./user-managment.component.scss']
})
export class UserManagmentComponent implements OnInit {
  displayedColumns: string[] = ['id', 'username', 'zbanowany', 'akcje'];
  users: User[];
  constructor(private userService: UserService) { }

  ngOnInit() {
  this.getUsersForAdm();
  }

  private getUsersForAdm = () => {
    this.userService.getUsersForAdmin().subscribe((users: any) => {
      this.users = users._embedded.users;
    });
  }

  banAccount(user: User) {
    this.userService.banUser(user.id)
    .subscribe((resp: any) => {
      this.getUsersForAdm();
    });
  }

  deleteAccount(userId: number) {
    this.userService.deleteUser(userId)
    .subscribe((resp: any) => {
      this.getUsersForAdm();
    });
  }

  unbanAccount(user: User) {
    this.userService.unbanUser(user.id)
    .subscribe((resp: any) => {
      this.getUsersForAdm();
    });
  }
}
