package pl.mgk.hubertrybarczyk.createyourself.service.jpa;

import org.springframework.stereotype.Service;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.repository.CelebrationRepository;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;

import java.util.HashSet;
import java.util.Set;

@Service
//@Profile("springdatajpa")
public class CelebrationJpaService implements CelebrationService {

    private final CelebrationRepository celebrationRepository;

    public CelebrationJpaService(CelebrationRepository celebrationRepository) {
        this.celebrationRepository = celebrationRepository;
    }

    @Override
    public Set<Celebration> findAll() {
        Set<Celebration> celebrations = new HashSet<>();
        celebrationRepository.findAll().forEach(celebrations::add);
        return celebrations;
    }

    @Override
    public Celebration findById(Long aLong) {
        return celebrationRepository.findById(aLong).orElse(null);
    }

    @Override
    public Celebration save(Celebration object) {
        return celebrationRepository.save(object);
    }

    @Override
    public void delete(Celebration object) {
        celebrationRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        celebrationRepository.deleteById(aLong);
    }
}
