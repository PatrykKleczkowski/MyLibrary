import {Author} from "@shared/model/Author";
import {Hire} from "@shared/model/Hire";

export interface Book {
  id: number;
  title: string;
  author: Author;
  hireList: Hire[];
  releaseDate: Date;
  available: boolean;
  hireDateFrom: Date;
  hireDateTo: Date;

}

export enum BookType{
  FANTASY = 'FANTASY',
  ROMANCE = 'ROMANCE',
  MYTHOLOGY = 'MYTHOLOGY',
  EDUCATION = 'EDUCATION'
}



