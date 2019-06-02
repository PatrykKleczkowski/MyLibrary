import {Book} from "@shared/model/Book";

export interface Author {
  id: number;
  firstName: string;
  lastName: string;
  books?: Book[];
}
