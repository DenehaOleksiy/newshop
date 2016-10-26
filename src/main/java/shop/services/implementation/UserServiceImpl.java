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
 * Created by Администратор on 14.09.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService{
    @Autowired
    private UserRepo userRepo;


    public void add(User user) {
        userRepo.saveAndFlush(user);
    }

    @Override
    public List<User> showAll() {
        return userRepo.findAll();
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }




    @Override
    public UserDetails loadUserByUsername(String l) throws UsernameNotFoundException {
        User user;

        try {
            user = userRepo.findUserByLogin(l);
            if(!user.isEnabled()){
                return null;
            }
        }
        catch (NoResultException e){
            return  null;
        }
        Collection<SimpleGrantedAuthority>grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(simpleGrantedAuthority);

        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), grantedAuthorities);
    }


    @Override
    public User findOne(int id) {
        return userRepo.findOne(id);
    }
}
