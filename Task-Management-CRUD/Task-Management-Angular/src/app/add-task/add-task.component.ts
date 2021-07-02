import {Component, OnInit} from '@angular/core';
import {Task} from '../model/task';
import {TaskService} from '../service/task.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-edit-form',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  form: FormGroup;
  task: Task = {};


  constructor(private taskService: TaskService,
              private router: Router,
              private builder: FormBuilder) {
  }

  ngOnInit(): void {
    const nonWhiteSpaceRegExp = /^[^ ][a-zA-Z0-9 ]/;

    this.form = this.builder.group({
      taskId: [null],
      taskName: ['',
        [
          Validators.required,
          Validators.pattern(nonWhiteSpaceRegExp),
          Validators.maxLength(150)
        ]
      ],
      taskDescription: ['', []],
      dueDate: ['', []]
    });
  }

  onSave(): void {
    this.task.name = this.form.controls.taskName.value;
    this.task.description = this.form.controls.taskDescription.value;
    this.task.dueDate = this.form.controls.dueDate.value;

    this.taskService.createTask(this.task).subscribe(() => {
      this.router.navigate(['']);
    });
  }

  onCancel(): void {
    this.router.navigate(['']);
  }
}
