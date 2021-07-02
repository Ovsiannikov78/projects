import {Component, OnInit} from '@angular/core';
import {Task} from '../model/task';
import {ActivatedRoute, Router} from '@angular/router';
import {TaskService} from '../service/task.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {

  form: FormGroup;
  task: Task;

  constructor(private taskService: TaskService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private builder: FormBuilder) {
  }

  ngOnInit(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');

    this.initForm();

    this.taskService.getTask(id).subscribe(data => {
      this.task = data;
      this.setFormValues();
    });


  }

  onSave(): void {
    console.log('Task for edit ', this.task);
    this.task.description = this.form.controls.taskDescription.value;
    this.task.dueDate = this.form.controls.dueDate.value;
    this.taskService.editTask(this.task).subscribe(
      () => this.router.navigate([''])
    );
  }

  onCancel(): void {
    this.router.navigate(['']);
  }

  setFormValues(): void {
    this.form.controls.taskDescription.setValue(this.task.description);
    this.form.controls.dueDate.setValue(this.task.dueDate);
  }

  private initForm(): void {
    this.form = this.builder.group({
      taskDescription: ['', []],
      dueDate: ['', []]
    });
  }
}
