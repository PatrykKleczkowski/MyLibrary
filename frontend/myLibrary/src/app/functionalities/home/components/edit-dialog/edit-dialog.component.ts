import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Author } from '@shared/model/Author';
import { Book } from '@shared/model/Book';
import { AuthorService } from '@shared/service/author.service';
import {BookService} from "@shared/service/book.service";

@Component({
  selector: 'app-edit-dialog',
  templateUrl: './edit-dialog.component.html',
  styleUrls: ['./edit-dialog.component.scss']
})
export class EditDialogComponent implements OnInit {

  authors: Author[];
  editForm: FormGroup = this.formBuilder.group({
    title: [],
    author: [],
    releaseDate: []
  });

  constructor(public dialogRef: MatDialogRef<EditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Book,
              private authorService: AuthorService,
              private formBuilder: FormBuilder,
              private bookService: BookService) {
  }

  ngOnInit() {
    this.editForm.get('title').setValue(this.data.title);
    this.editForm.get('author').setValue(this.data.author.id);
    this.editForm.get('releaseDate').setValue((new Date(this.data.releaseDate)).toISOString());

    this.fetchAuthors();
  }


  private fetchAuthors = () => {
    this.authorService.getAllAuthors().subscribe((authors: any) => {
      this.authors = authors._embedded.authors;
    });
  }

  editBook() {
   const title: string = this.editForm.get('title').value;
   const date: Date = this.editForm.get('releaseDate').value;
   const author: number = this.editForm.get('author').value;
   const bookId: number = this.data.id;

    console.log("id autora:" + author);
    console.log(title);
   console.log(date);
    console.log("id ksiazki" + typeof bookId);

    this.bookService.editBook(bookId, title, author, date).subscribe();
  }

}
