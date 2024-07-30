package generics.exercise16.scenario2;

public class Application<T> {
    private Repository<T> repo;

    public void setRepository(Repository<T> repository) {
        this.repo = repository;
    }

    public T loadData(String id) {
        return repo.findById(id);
    }
}
