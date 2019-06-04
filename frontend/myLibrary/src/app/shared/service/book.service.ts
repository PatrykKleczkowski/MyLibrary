import {Injectable} from '@angular/core';
import {environment} from "@env/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "@shared/model/Book";
import {Hire} from "@shared/model/Hire";
import {EditedBookDTO} from "@shared/model/dto/EditedBookDTO";

const API_URL = environment.apiUrl;


@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) {
  }


  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${API_URL}/books/getAll`);
  }

  deleteBook(bookId: number) {
    return this.http.delete(`${API_URL}/books/${bookId}`);
  }

  editBook(bookId: number, title: string, authorId: number, releaseDate: Date) {
    console.log(bookId);
    return this.http.post(`${API_URL}/books/edit`, {bookId, title, authorId, releaseDate});
  }

  rentBook(bookId: number) {
    return this.http.get<any>(`${API_URL}/books/rentBook/` + bookId);
  }

  getBorrowedBooks(): Observable<Hire[]> {
    return this.http.get<any>(`${API_URL}/hires/getHires`);
  }

  returnBook(id: number) {
    return this.http.get<any>(`${API_URL}/books/returnBook/` + id);
  }

  saveNewBook(title: string, authorId: number, releaseDate: Date) {
    return this.http.post<any>(`${API_URL}/books/addBook/`, {title, authorId, releaseDate})
  }


}





