import { Component, OnInit } from '@angular/core';
import { TodoDataServiceService } from '../service/data/todo-data-service.service';
import { Router } from '@angular/router';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public isDone: boolean,
    public targetDate: Date
  ) {}

}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css'],
})
export class ListTodosComponent implements OnInit {
  todos: Todo[] = [];
  message: string = '';
  constructor(
    private todoService: TodoDataServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.refreshTodos();
  }

  refreshTodos() {
    this.todoService.retrieveAllTodos('nosst-bot').subscribe((response) => {
      this.todos = response;
    });
  }

  deleteTodo(id: number) {
    this.todoService.deleteTodo('nosst-bot', id).subscribe((response) => {
      this.message = 'Delete Successful!';
      this.refreshTodos();
    });
  }

  modifyTodo(id: number) {
    console.log('updating');
    this.router.navigate(['todos', id])
  }

  addTodo(id:number = -1) {
    console.log('nuevo Todo');
    this.router.navigate(['todos', id])
  }
  

  // todos = [
  //   new Todo(1, 'Learn to Dance', false, new Date()),
  //   new Todo(2, 'Become an Expert at Angular', false, new Date()),
  //   new Todo(3, 'Visit England', false, new Date()),
  //   new Todo(4, 'Study English', false, new Date()),

  // ]

  // todo = {
  //   id: 1,
  //   description: 'Learn to Dance'
  // }
}
