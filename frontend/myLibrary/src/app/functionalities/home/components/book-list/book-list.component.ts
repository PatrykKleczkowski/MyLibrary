import {Component, OnInit} from '@angular/core';
import {Book} from "@shared/model/Book";
import {BookService} from "@shared/service/book.service";
import {any} from "codelyzer/util/function";
import {AuthService} from "@core/service";
import {DialogService} from "@shared/service/dialog.service";
import {BorrowedBooksComponent} from "@features/home/components/borrowed-books/borrowed-books.component";
import {Hire} from "@shared/model/Hire";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {


  displayedColumns: string[] = ['title', 'author', 'releaseDate', 'available', 'borrowBook'];
  borrowed: string[] = ['title', 'author', 'releaseDate', 'dateFrom', 'dateTo', 'action'];

  books: Book[];
  hires: Hire[];


  constructor(private bookService: BookService,
              private authService: AuthService,
              private dialogService: DialogService) {
  }

  ngOnInit() {
    this.fetchBooks();
    this.fetchBorrowedBooks();
  }

  private fetchBooks = () => {
    this.bookService.getAllBooks().subscribe((books: any) => {
      this.books = books;
      console.log(books);
    })
  }

  fetchBorrowedBooks = () => {
    this.bookService.getBorrowedBooks().subscribe((hires: any) => {
      this.hires = hires;
    })
  }

  isAdmin() {
    return this.authService.isAdmin();
  }

  private deleteBook(bookId: number) {
    this.bookService.deleteBook(bookId).subscribe((resp: any) => {
      this.fetchBooks();
    })

  }

  private editDialog(book: Book) {
    this.dialogService.openEditDialog(book);
  }

  rentBook(id: number) {
    this.bookService.rentBook(id).subscribe((resp: any) => {
      this.fetchBooks();
      this.fetchBorrowedBooks();
    })
  }

  returnBook(id: number){
    this.bookService.returnBook(id).subscribe((resp: any) => {
      this.fetchBooks();
      this.fetchBorrowedBooks();
    })
  }

  openNewBookDialog(){
    this.dialogService.openNewBookDialog();

  }

  openNewAuthorDialog(){
    this.dialogService.openNewAuthorDialog();
  }


}
