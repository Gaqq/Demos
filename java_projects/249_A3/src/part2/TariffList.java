package part2;

import java.util.*;
//
//Assignment 3 
//Question: 1 
//Written by: Jack Fraser 40266009 
//

public class TariffList implements TariffPolicy, Cloneable {

	private int iterations=0;
	/**
	 * the number of iterations perfomed on the most recent call of TariffList.find()
	 * @return iterations
	 */
	public int getiterations() {
		return iterations; }
	//inner class
	class TariffNode{
		
		private Tarrif tarrif;
		private TariffNode tarrifnode;
		/**
		 * paramerterized constructor
		 * @param tarrif
		 * @param tarrifnode
		 */
		public TariffNode(Tarrif tarrif, TariffNode tarrifnode) {
			
			this.tarrif = tarrif;
			this.tarrifnode = tarrifnode;
		}
		/**
		 * default constructor
		 * initializes variable to null
		 */
		public TariffNode() {
			
			this.tarrif = null;
			this.tarrifnode = null;
		}
		/**
		 * copy constructor
		 * @param copy
		 */
		public TariffNode(TariffNode copy) {
					
			this.tarrif = copy.tarrif;
			this.tarrifnode = copy.tarrifnode;
		}
		/**
		 * @return a deep copy of calling object
		 */
		public TariffNode clone() {
			return new TariffNode(this);
		}
		//getters and setters
		/*
		 * @return tarrif object
		 */
		public Tarrif getTarrif() {
			return tarrif;
		}
		/**
		 * sets the tarrif object
		 * @param tarrif
		 */
		public void setTarrif(Tarrif tarrif) {
			this.tarrif = tarrif;
		}
		/**
		 * 
		 * @return the tarrifnode object
		 */
		public TariffNode getTarrifnode() {
			return tarrifnode;
		}
		/**
		 * sets tarrifnode=paramater
		 * @param tarrifnode
		 */
		public void setTarrifnode(TariffNode tarrifnode) {
			this.tarrifnode = tarrifnode;
		}
		
		
		@Override
		/**
		 * @return true if calling object equals param false otherwise
		 */
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof TariffNode)) {
				return false;
			}
			TariffNode other = (TariffNode) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
				return false;
			}
			return Objects.equals(tarrif, other.tarrif) && Objects.equals(tarrifnode, other.tarrifnode);
		}
		private TariffList getEnclosingInstance() {
			return TariffList.this;
		}
		
		
		
		
	}//end of TariffNode
	
	
	private TariffNode head;
	private int size;
	/**
	 * default constructor
	 * initializes an empty list
	 */
	public TariffList() {
		this.head=null;
		this.size=0;
	} 
	/**
	 * copy constructor
	 * @param copy
	 */
	public TariffList(TariffList copy) {
		this.head=copy.head;
		this.size=copy.size;
	}
	/**
	 * adds a given tarrif as the fisrt element of the listf 
	 * @param tarrif toadd
	 */
	public void addtostart(Tarrif toadd) {
		TariffNode newhead=new TariffNode(toadd,this.head);
		this.head=newhead;
		size++;
	}
	/**
	 * inserts a given tarrif at the given index in the list
	 * @param toadd
	 * @param index
	 * @throws NoSuchElementException
	 */
	public void insertAtindex(Tarrif toadd,int index) throws NoSuchElementException{
		if(index<0||index>=(size)) {throw new NoSuchElementException();}
		if(index==0) {this.addtostart(toadd);return;}
		else {
		TariffNode placeholder=this.head;
		for(int i=0;i<index-1;i++) {
			
			placeholder=placeholder.getTarrifnode();
		}
		
				
				TariffNode placeholder2=placeholder.getTarrifnode();
				placeholder.setTarrifnode(new TariffNode(toadd,placeholder2));
				size++;
		}
		
	}
	/**
	 * removes the first object from the list
	 */
	public void deleteFromStart() {
		if(this.head!=null) {
			if(this.head.tarrifnode==null) {this.head=null;}
			else{this.head=head.getTarrifnode();};
			size--;
		}
	}
	/**
	 * remove the object from the given index
	 * @param index
	 * @throws NoSuchElementException
	 */
	public void deleteFromindex(int index) throws NoSuchElementException{
		if(index<0||index>=(size)) {throw new NoSuchElementException();}
		if(index==0) {deleteFromStart();return;}
		else {
		TariffNode placeholder=this.head;
		for(int i=0;i<index-1;i++) {
			
			placeholder=placeholder.getTarrifnode();}
		
		TariffNode placeholder2=placeholder.getTarrifnode();
		placeholder.setTarrifnode(placeholder2.getTarrifnode());
		}
		size--;
	} 
	/**
	 * replaces the object at the given index with the given object
	 * @param newtarrif
	 * @param index
	 */
	public void replaceAtIndex(Tarrif newtarrif,int index) {
		if(index<0||index>=this.size) {return;}
		if(index==0) {
			TariffNode placeholder=this.head;
			this.head=new TariffNode(newtarrif,placeholder.getTarrifnode());
		}
		else {
		TariffNode placeholder=this.head;
		for(int i=0;i<index-1;i++) {
			placeholder=placeholder.getTarrifnode();}
		TariffNode placeholder2=placeholder.getTarrifnode();
		placeholder.setTarrifnode(new TariffNode(newtarrif,placeholder2));
		}
}
	//this violates privacy encapsulation because a reference is returned and thus can be used to modify the object
	//to fix this just return a clone of placeholder, or make the node class private 
	/**
	 * finds and returns the TariffNode that contains matches the given destination origin and category
	 * @param destination
	 * @param origin
	 * @param category
	 * @return coresponding TariffNode
	 */
	public TariffNode find(String destination, String origin, String category) {
		TariffNode placeholder=this.head;
		
		for(int i=0;i<size;i++) {
			iterations=i+1;
			if(placeholder.getTarrif().getDestinationCountry().equals(destination)
			&&placeholder.getTarrif().getProductCategory().equals(category)
			&&placeholder.getTarrif().getOriginCountry().equals(origin)) {
				
				return placeholder;
			}
			
			placeholder=placeholder.getTarrifnode();
		}
		return null;
		
	}
	/**
	 * Checks if a given tariff is in the calling list
	 * @param destination
	 * @param origin
	 * @param category
	 * @return true if Tariff is in list false otherwise
	 */
	public boolean contains(String destination, String origin, String category) {
			TariffNode placeholder=this.head;
			for(int i=0;i<size;i++) {
				if(placeholder.getTarrif().getDestinationCountry().equals(destination)
				&&placeholder.getTarrif().getProductCategory().equals(category)
				&&placeholder.getTarrif().getOriginCountry().equals(origin)) {
					return true;
				}
				placeholder=placeholder.getTarrifnode();
			}
			return false;
	}
	
	
	
	
	
	@Override
	/**
	 * @return true if the calling object is equal to the parameter obj
	 * @param obj
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TariffList)||obj==null) {
			return false;
		}
		TariffList other = (TariffList) obj;
		
		if(other.size!=this.size) {return false;}
		TariffNode placeholder1=this.head;
		TariffNode placeholder2=other.head;
		for(int i=0;i<this.size-1;i++) {
			
			if(!placeholder1.getTarrif().equals(placeholder2.getTarrif())) {return false;}
			placeholder1=placeholder1.getTarrifnode();
			placeholder2=placeholder2.getTarrifnode();
			}
		if(!placeholder1.getTarrif().equals(placeholder2.getTarrif())) {return false;}
		return true;
	}
	/*
	 * prints to console the list of Tarrifs
	 * 
	 */
	public void printlist() {
		System.out.println(this.size);
		if(this.size==0) {System.out.println("the list is empty.");return;}
		TariffNode placeholder=head;
		//System.out.println(placeholder.getTarrif());
		for(int i=0;i<this.size;i++) {
			
			if(placeholder!=null&&placeholder.getTarrifnode()!=null) {
			System.out.println(placeholder.getTarrif());
			placeholder=placeholder.getTarrifnode();
			}	
		}
		System.out.println(placeholder.getTarrif());
		
	}
	
	@Override
	/**
	 * evalutes trade based on the proposed Tariff and minimum Tariff and returns the appropriate string indicating 
	 * trade acceptance status
	 * @param destinationCountry
	 * @param minimumTariff
	 * @return "accepted if proposedTariff>=minimumTariff, "conditionally accepted" if proposedTariff is within 20% of minimumTariff, "rejected" otherwise
	 */
	public String evaluateTrade(double proposedTariff, double minimumTariff) {
		if(proposedTariff>=minimumTariff) {
			
			return"accepted";
		}
		else {
			if(proposedTariff>=(minimumTariff-0.2*minimumTariff)){
				
				return "conditionally accepted";
			}
			else {
				return "rejected";}
		}
	}

}
