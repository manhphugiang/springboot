import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
export const appConfig: ApplicationConfig = {
 providers: [{provide: LocationStrategy, useClass: HashLocationStrategy},provideRouter(routes), provideHttpClient(), provideZoneChangeDetection({eventCoalescing: true})]
};
