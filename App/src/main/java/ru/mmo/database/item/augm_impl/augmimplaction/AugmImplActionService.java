package ru.mmo.database.item.augm_impl.augmimplaction;

import java.util.List;

public interface AugmImplActionService {
	void addAction(AugmImplAction augmImplAction);
	void deleteAction(AugmImplAction augmImplAction);
	void updateAction(AugmImplAction augmImplAction);
	AugmImplAction getAction(Long id);
	List<AugmImplAction> getAll();
}
