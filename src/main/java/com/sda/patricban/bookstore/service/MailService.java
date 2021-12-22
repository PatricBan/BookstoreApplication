package com.sda.patricban.bookstore.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface MailService {
    void sendEmail(String from, String to, String subject, String content) throws MessagingException;
}
