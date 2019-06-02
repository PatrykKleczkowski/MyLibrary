import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Book} from "@shared/model/Book";
import {AuthorService} from "@shared/service/author.service";
import {Author} from "@shared/model/Author";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-edit-dialog',
  templateUrl: './edit-dialog.component.html',
  styleUrls: ['./edit-dialog.component.scss']
})
export class EditDialogComponent implements OnInit {

  authors: Author[];
  editForm: FormGroup;
  startDate: Date;
  bookAuthor: Author = this.data.author;

  constructor(public dialogRef: MatDialogRef<EditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Book,
              private authorService: AuthorService) {
  }

  ngOnInit() {
    this.fetchAuthors();
    this.initEditForm();
    this.startDate = this.data.releaseDate;
    console.log(this.bookAuthor);
  }


  private fetchAuthors = () => {
    this.authorService.getAllAuthors().subscribe((authors: any) => {
      this.authors = authors._embedded.authors;
    })
  }

  initEditForm() {
    this.editForm = new FormGroup({
      title: new FormControl(),
      author: new FormControl(),
    })
  }

  editBook() {

  }


}
