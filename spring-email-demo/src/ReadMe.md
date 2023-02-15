### Application to send email through gmail smtp

- **Steps**
1. Set up the .yml or properties file
2. Inject the JavaMailSender dependency in service class
3. Create a method which accepts email id of receiver, email subject, email body, etc.
4. Create object of SimpleMailMessage object.
5. Add all the details to SimpleMailMessage object.
6. Add this message to JavaMailSender object.
7. Send the email through send() method.
8. For testing the application, I've used EventListener(ApplicationReadyEvent.class) 