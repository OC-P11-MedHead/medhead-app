// message.component.ts

import { Component, Input, OnInit } from '@angular/core';
import { MessageService } from 'src/app/service/message.service';


@Component({
    selector: 'app-message',
    templateUrl: './message.component.html',
    styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
    @Input() message: string | undefined;
    messageType: 'success' | 'error' | undefined;
    constructor(private messageService: MessageService) { }

    ngOnInit(): void {
        this.messageService.message$.subscribe(({ message, type }) => {
            this.message = message;
            this.messageType = type;
            setTimeout(() => {
                this.message = undefined;
                this.messageType = undefined;
            }, 5000); // Masque le message après X ms
        })
    }
}
    
