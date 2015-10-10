package by.academy.service.srv;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.academy.pojos.Role;
import by.academy.pojos.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	static Logger logger= Logger.getLogger(UserDetailsServiceImpl.class.getName());
	
    @Autowired
    private UserService userService;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	logger.info("********loadUserByUsername*********");
        User user = userService.getUserByName(userName);
        logger.info("********user="+user);
        List<Role> roles = userService.getRolesByUserId(user.getId());
        Set<GrantedAuthority> rolesGA = new HashSet();
        for (Role role : roles) {
        	rolesGA.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        
        logger.info("********roles="+roles);
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUserName(), 
                                                                       user.getPassword(), 
                                                                       rolesGA);
        logger.info("********userDetails="+userDetails);
        return userDetails;
    }
 
}
