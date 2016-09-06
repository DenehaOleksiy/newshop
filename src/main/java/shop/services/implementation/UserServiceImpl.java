package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shop.entity.User;
import shop.repo.UserRepo;
import shop.services.UserService;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;
import java.util.*;

/**
 * Created by Администратор on 14.07.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public void add(User user) {
        userRepo.save(user);
    }

    public void edit(User user) {
        userRepo.save(user);
    }

    public void remove(int id) {
        userRepo.delete(id);
    }

    public User findOneById(int id) {
        return userRepo.findOne(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepo.findUserByLogin(login);
        } catch (NoResultException e) {
            return null;
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),user.getPassword(),authorities);
    }


    @Override
    public void sendEmail(int id, String email, String userName, String password, String registrationVar) {

        try{

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("alex.lviv.1975@gmail.com", "gelios1975");
                }
            });

            mailSession.setDebug(true); // Enable the debug mode

            Message msg = new MimeMessage( mailSession );

            msg.setFrom( new InternetAddress( "alex.lviv.1975@gmail.com" ) );
            msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email) );
            msg.setSentDate( new Date());
            msg.setSubject( "Registration" );


            registrationVar = registrationVar.replace(".", "-");


            msg.setText( "Hello " + userName + ",\n You'r login: " + email + "\n You'r password: " + password
                    + "\n Please copy this link and follow them\n Registration link:   localhost:8080/registration/" + registrationVar);

            Transport.send( msg );

        }catch(Exception E){
            System.out.println( "Oops something has gone wrong!");
            System.out.println( E );
        }


    }


}
