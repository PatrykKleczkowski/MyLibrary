import {Component, OnInit} from '@angular/core';
import {Book} from "@shared/model/Book";
import {BookService} from "@shared/service/book.service";
import {Hire} from "@shared/model/Hire";

@Component({
  selector: 'app-borrowed-books',
  templateUrl: './borrowed-books.component.html',
  styleUrls: ['./borrowed-books.component.scss']
})
export class BorrowedBooksComponent implements OnInit {

  hires: Hire[];

  displayedColumns: string[] = ['title', 'author', 'releaseDate', 'dateFrom', 'dateTo', 'action'];


  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.fetchBorrowedBooks();
  }


   fetchBorrowedBooks = () => {
    this.bookService.getBorrowedBooks().subscribe((hires: any) => {
      this.hires = hires;
      console.log(this.hires[0].hireDateFrom + "asd");
    })
  }

}
