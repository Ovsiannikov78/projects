import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Task} from '../model/task';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private taskApi = 'http://localhost:8080/api/tasks';

  constructor(private http: HttpClient ) { }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.taskApi, task, this.httpOptions);
  }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.taskApi, this.httpOptions);
  }

  getTask(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.taskApi}/${id}`, this.httpOptions);
  }

  deleteTask(id: number): Observable<Task> {
    return this.http.delete<Task>(`${this.taskApi}/${id}`, this.httpOptions);
  }

  editTask(task: Task): Observable<void> {
    return this.http.put<void>(this.taskApi, task, this.httpOptions);
  }
}
