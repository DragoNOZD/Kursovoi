package ru.mmo.database.hibernate;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetBasedPageRequest implements Pageable {

	private int limit;
	private int offset;

	private String sortColumn;
	private Sort sort;

	public OffsetBasedPageRequest(int limit, int offset, String sortColumn) {
		if (limit < 1) {
			throw new IllegalArgumentException("Limit must not be less than one!");
		}
		if (offset < 0) {
			throw new IllegalArgumentException("Offset index must not be less than zero!");
		}
		this.limit = limit;
		this.offset = offset;
		this.sortColumn = sortColumn;
		sort = new Sort(Sort.Direction.DESC, sortColumn);
	}

	@Override
	public int getPageNumber() {
		return offset / limit;
	}

	@Override
	public int getPageSize() {
		return limit;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Pageable next() {
		return new OffsetBasedPageRequest(getPageSize(), (getOffset() + getPageSize()), sortColumn);
	}

	public Pageable previous() {
		return hasPrevious() ?
				new OffsetBasedPageRequest(getPageSize(), (getOffset() - getPageSize()), sortColumn) : this;
	}

	@Override
	public Pageable previousOrFirst() {
		return hasPrevious() ? previous() : first();
	}

	@Override
	public Pageable first() {
		return new OffsetBasedPageRequest(1, getPageSize(), sortColumn);
	}

	@Override
	public boolean hasPrevious() {
		return offset > limit;
	}
}
