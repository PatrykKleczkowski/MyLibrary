import {Component, OnInit} from '@angular/core';
import {AuthorService} from "@shared/service/author.service";
import {Author} from "@shared/model/Author";
import {FormControl, FormGroup} from "@angular/forms";
import {BookType} from "@shared/model/Book";
import {BookService} from "@shared/service/book.service";

@Component({
  selector: 'app-new-book-dialog',
  templateUrl: './new-book-dialog.component.html',
  styleUrls: ['./new-book-dialog.component.scss']
})
export class NewBookDialogComponent implements OnInit {

  authors: Author[];
  newBookForm: FormGroup;
  selectedValue: Author;


  constructor(private authorService: AuthorService,
              private bookService: BookService) {
  }

  ngOnInit() {
    this.fetchAuthors();
    this.initEditForm();
  }

  private fetchAuthors = () => {
    this.authorService.getAllAuthors().subscribe((authors: any) => {
      this.authors = authors._embedded.authors;
    })
  }

  initEditForm() {
    this.newBookForm = new FormGroup({
      title: new FormControl(),
      author: new FormControl(),
      type: new FormControl(),
      releaseDate: new FormControl()
    })
  }

  saveBook() {
    const title: string = this.newBookForm.value.title;
    const author: Author = this.newBookForm.value.author;
    const releaseDate: Date = this.newBookForm.value.releaseDate;
    const authorId = author.id;


    console.log(this.newBookForm.value.type);

    this.bookService.saveNewBook(title, authorId, releaseDate).subscribe();
    window.location.reload();

  }


  values() {
    return Object.keys(BookType).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

}
