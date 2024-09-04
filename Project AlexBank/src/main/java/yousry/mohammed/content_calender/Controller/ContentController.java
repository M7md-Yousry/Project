package yousry.mohammed.content_calender.Controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yousry.mohammed.content_calender.model.Content;
import yousry.mohammed.content_calender.repository.ContentJDBCRepo;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/content")
public class ContentController {

    private final ContentJDBCRepo repository;

    public ContentController(ContentJDBCRepo repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> finAll() {
        return repository.getAllContent();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.getContent(id);}

    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.createContent(content.fullname(), content.address(), content.maritalstatus(), content.department(), content.githuburl());
    }

    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content content, @PathVariable Integer id) {
        Content existingContent = repository.getContent(id);
        if (existingContent != null) {
            repository.updateContent(
                    id,
                    content.fullname(),
                    content.address(),
                    content.maritalstatus(),
                    content.department(),
                    content.githuburl()
            );
        }
}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteContent(id);
    }
}

