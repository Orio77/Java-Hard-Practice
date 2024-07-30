package streamAPI.exercise6_handlingNulls.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SocialMediaApp {
    
    public List<User> filterNonNullUsers(List<User> users) {
        return users.stream().filter(u -> u != null && u.getPosts() != null && u.getPosts().stream().anyMatch(p -> p.getComments() != null)).sorted(Comparator.comparing((User u) -> u.getPosts().stream().map(p -> p.getComments()).count())).toList();
    }

    public List<Post> sortPostsByComments(List<User> users) {
        return users.stream().filter(Objects::nonNull).flatMap(user -> user.getPosts().stream()).filter(Objects::nonNull).filter(p -> p.getComments() != null).sorted(Comparator.comparing(p -> p.getComments().size())).toList();
    }

    public List<User> filterAndSortParallel(List<User> users) {
        return users.parallelStream().filter(u -> u != null && u.getPosts() != null && u.getPosts().stream().anyMatch(p -> p.getComments() != null)).sorted(Comparator.comparing((User u) -> u.getPosts().stream().map(p -> p.getComments()).count())).toList();
    }

    public long comparePerformance(List<User> users) {

        long start1 = System.nanoTime();
        filterNonNullUsers(users);
        long end1 = System.nanoTime();

        long result1 = end1 - start1;

        long start2 = System.nanoTime();
        filterAndSortParallel(users);
        long end2 = System.nanoTime();

        long result2 = end2 - start2;

        return result2 - result1;
    }

    public Map<User, Long> mapUsersToPostCount(List<User> users) {
        return users.stream().collect(Collectors.toMap(Function.identity(), user -> user.getPosts().stream().filter(Objects::nonNull).count()));
    }

    public Map<Post, Long> mapPostsToCommentCount(List<User> users) {
        return users.stream().flatMap(user -> user.getPosts().stream()).collect(Collectors.toMap(Function.identity(), post -> post.getComments().stream().filter(Objects::nonNull).count()));
    }

    public Optional<User> findFirstUserWithPost(List<User> users) {
        return users.stream().filter(user -> user.getPosts() != null).findFirst();
    }

    public Optional<Post> findFirstPostWithComment(List<User> users) {
        return users.stream().flatMap(user -> user.getPosts().stream()).filter(post -> post.getComments() != null && !post.getComments().isEmpty()).findFirst();
    }

    public Optional<Comment> findFirstComment(List<User> users) {
        return users.stream().flatMap(user -> user.getPosts().stream().filter(Objects::nonNull)).flatMap(post -> post.getComments().stream().filter(Objects::nonNull)).findFirst();
    }
}
