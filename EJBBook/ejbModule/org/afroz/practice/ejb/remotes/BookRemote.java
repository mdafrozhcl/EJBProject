package org.afroz.practice.ejb.remotes;

import javax.ejb.Remote;

@Remote
public interface BookRemote {
	public String getBook();
}
