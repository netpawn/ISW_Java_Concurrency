package it.unipr.informatica.exam.luglio5.resourceManager;

public interface ResourceManager {
	public void acquireResource(int i); //acquisisce i e (i+1)%N
	public void freeResource(int i); //libera //acquisisce i e (i+1)%N
}
