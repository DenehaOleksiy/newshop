package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shop.repo.UserRepo;
import shop.services.UserService;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
