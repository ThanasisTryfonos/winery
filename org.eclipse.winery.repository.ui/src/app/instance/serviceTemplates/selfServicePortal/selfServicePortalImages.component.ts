/**
 * Copyright (c) 2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Niko Stadelmaier - initial API and implementation
 *     Lukas Balzer - corrected image upload of SelfServicePortal
 */
import { Component, OnInit } from '@angular/core';
import { SelfServicePortalService } from './selfServicePortal.service';
import { WineryNotificationService } from '../../../wineryNotificationModule/wineryNotification.service';

@Component({
    selector: 'winery-self-service-images',
    templateUrl: 'selfServicePortalImages.component.html'
})
export class SelfServicePortalImagesComponent implements OnInit {
    loading = true;
    iconPath: string;
    imagePath: string;

    constructor(private service: SelfServicePortalService,
                private notify: WineryNotificationService) {
    }

    ngOnInit() {
        this.loading = true;
        this.iconPath = this.service.getIconPath();
        this.imagePath = this.service.getImagePath();
        this.loading = false;
    }

    onUploadSuccess(name: string) {
        this.loading = true;
        this.notify.success('Successfully uploaded ' + name);
        const number = Math.random();
        this.iconPath = this.service.getIconPath() + '?' + number;
        this.imagePath = this.service.getImagePath() + '?' + number;
        this.loading = false;
    }
}
