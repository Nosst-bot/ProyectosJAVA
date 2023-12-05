import { Component, OnInit } from '@angular/core';
import { TodoDataServiceService } from '../service/data/todo-data-service.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent implements OnInit {
  id: number = 0;
  todo: Todo = new Todo(0, '', false, new Date());
  constructor(
    private todoService: TodoDataServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.todo.id = this.id;

    if (this.id != -1) {
      this.todoService
        .retrieveTodo('nosst-bot', this.id)
        .subscribe((data) => (this.todo = data));
    }
  }

  saveTodo() {
    if (this.id === -1) {
      //Create todo
      this.todoService
      .createTodo('nosst-bot', this.todo)
      .subscribe( () => this.router.navigate(['todos']));
    } else {
      this.todoService
        .modifyTodo('nosst-bot', this.id, this.todo)
        .subscribe();

      setTimeout(() => {
        this.router.navigate(['todos']);
      }, 500);
    }
  }
}
