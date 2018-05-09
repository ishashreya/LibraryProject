package dao;

import java.util.List;

import model.Librarian;

public interface LibrarianDao {

	public void addLibrarian(Librarian l);
	public void updateLibrarian(Librarian l);
	public List<Librarian> listLibrarians();
	public Librarian getLibrarianById(int id);
	public void removeLibrarian(int id);


}
