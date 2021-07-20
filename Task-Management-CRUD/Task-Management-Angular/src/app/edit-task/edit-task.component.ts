import {Component, OnDestroy, OnInit} from '@angular/core';
import {Task} from '../model/task';
import {ActivatedRoute, Router} from '@angular/router';
import {TaskService} from '../service/task.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit, OnDestroy {

  form: FormGroup;
  task: Task;
  editSub: Subscription;
  getSub: Subscription;

  constructor(private taskService: TaskService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private builder: FormBuilder) {
  }

  ngOnInit(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');

    this.initForm();

    this.getSub = this.taskService.getTask(id).subscribe(data => {
      this.task = data;
      this.setFormValues();
    });
  }

  ngOnDestroy(): void {
      if (this.editSub) {
        this.editSub.unsubscribe();
      }
      if (this.getSub) {
        this.getSub.unsubscribe();
      }
    }

  onSave(): void {
    console.log('Task for edit ', this.task);
    this.task.description = this.form.controls.taskDescription.value;
    this.task.dueDate = this.form.controls.dueDate.value;
    this.editSub = this.taskService.editTask(this.task).subscribe(
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
