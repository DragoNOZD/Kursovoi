package ru.mmo.database.item.augm_impl.augmimplaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AugmImplActionServiceImpl implements AugmImplActionService {

	private AugmImplActionRepository repository;

	@Autowired
	public AugmImplActionServiceImpl(AugmImplActionRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addAction(AugmImplAction augmImplAction) {
		repository.saveAndFlush(augmImplAction);
	}

	@Override
	public void deleteAction(AugmImplAction augmImplAction) {
		repository.delete(augmImplAction);
	}

	@Override
	public void updateAction(AugmImplAction augmImplAction) {
		addAction(augmImplAction);
	}

	@Override
	public AugmImplAction getAction(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<AugmImplAction> getAll() {
		return repository.findAll();
	}
}
