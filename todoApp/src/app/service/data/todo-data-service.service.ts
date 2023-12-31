import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL, TODO_JPA_API_URL } from 'src/app/app.constants';
import { Todo } from 'src/app/list-todos/list-todos.component';

@Injectable({
  providedIn: 'root',
})
export class TodoDataServiceService {
  constructor(private http: HttpClient) {}

  retrieveAllTodos(username: string | null) {
    return this.http.get<Todo[]>(
      `${TODO_JPA_API_URL}/users/${username}/todos`
    );
  }

  deleteTodo(username: string | null, id: number) {
    return this.http.delete(
      `${API_URL}/users/${username}/todos/${id}`
    );
  }

  retrieveTodo(username: string, id: number) {
    return this.http.get<Todo>(
      `${TODO_JPA_API_URL}/users/${username}{/todos/${id}`
    );
  }

  modifyTodo(username: string, id: number, todo: Todo) {
    return this.http.put(
      `${API_URL}/users/${username}/todos/${id}`,
      todo
    );
  }

  createTodo(username: string, todo: Todo) {
    return this.http.post(
      `${API_URL}/users/${username}/todos`,
      todo
    );
  }
}
