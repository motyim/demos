package me.motyim.learn.spring.SpringDataArabic.rest;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.motyim.learn.spring.SpringDataArabic.entity.Comments;
import me.motyim.learn.spring.SpringDataArabic.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 19, 2018 
 */
@RestController
@RequestMapping("/rest")
public class CommentController {

    @Autowired
    CommentRepo commentRepo ; 
    @GetMapping("/comment/{comment}")
    public String addComment(@PathVariable String comment){
        try {
            String s = new String(comment.getBytes(), "UTF-8");
            System.out.println(s);
            Comments c = new Comments();
            c.setComment(comment);
            commentRepo.save(c);
            return "done";
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }
    
}
