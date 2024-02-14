// message.service.ts

import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private messageSubject = new Subject<{ message: string, type: 'success' | 'error'}>();

  message$ = this.messageSubject.asObservable();

  showMessage(messageInfo: { message: string, type: 'success' | 'error' }): void {
    this.messageSubject.next(messageInfo);
  }
}
