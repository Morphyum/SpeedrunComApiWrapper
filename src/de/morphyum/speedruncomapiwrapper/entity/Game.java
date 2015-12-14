package de.morphyum.speedruncomapiwrapper.entity;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Game {

	private String id;
	private List<Name> names;
	private String abbreviation;
	private URI weblink;
	private String released;
	private List<Ruleset> ruleset;
	private Boolean romhack;
	private List<String> platforms;
	private List<String> regions;
	private List<Moderator> moderators;
	private Date created;
	private List<Asset> assets;
	private List<Link> links;

	public Game(String id, List<Name> names, String abbreviation, URI weblink, String released, List<Ruleset> ruleset, Boolean romhack, List<String> platforms,
			List<String> regions, List<Moderator> moderators, Date created,List<Asset> assets,List<Link> links) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
