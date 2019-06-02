import {Book} from "@shared/model/Book";
import {User} from "@shared/model/user";

export interface Hire {
  id: number;
  book: Book;
  user: User;
  hireDateFrom: Date;
  hireDateTo?: Date;
}
