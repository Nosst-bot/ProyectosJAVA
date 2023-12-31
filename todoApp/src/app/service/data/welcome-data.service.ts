import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class HelloWorldBean {
  constructor(public message: String) {}
}

@Injectable({
  providedIn: 'root',
})
export class WelcomeDataService {
  constructor(private http: HttpClient) {}

  executeHelloWorldBeanService() {
    return this.http.get<HelloWorldBean>(
      'http://localhost:8080/hello-world-bean'
    );
  }

  //http://localhost:8080/hello-world/path-variable/nosst-bot

  executeHelloWorldBeanServiceWithParam(name: string) {
    return this.http.get<HelloWorldBean>(
      `http://localhost:8080/hello-world/path-variable/${name}`
    );
  }
}
