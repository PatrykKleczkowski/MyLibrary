import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AuthorService} from "@shared/service/author.service";

@Component({
  selector: 'app-new-author-dialog',
  templateUrl: './new-author-dialog.component.html',
  styleUrls: ['./new-author-dialog.component.scss']
})
export class NewAuthorDialogComponent implements OnInit {


  newAuthorForm: FormGroup;


  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
    this.initEditForm();
  }


  initEditForm() {
    this.newAuthorForm = new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl()
    })
  }

  saveAuthor() {
    const firstName: string = this.newAuthorForm.value.firstName;
    const lastName: string = this.newAuthorForm.value.lastName;

    this.authorService.saveNewAuthor(firstName, lastName).subscribe();
    window.location.reload();
  }
}
