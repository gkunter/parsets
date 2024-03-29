package edu.uncc.parsets.data;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * Copyright (c) 2009, Robert Kosara, Caroline Ziemkiewicz,
 *                     and others (see Authors.txt for full list)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the name of UNC Charlotte nor the names of its contributors
 *      may be used to endorse or promote products derived from this software
 *      without specific prior written permission.
 *      
 * THIS SOFTWARE IS PROVIDED BY ITS AUTHORS ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
\* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class CategoryHandle implements Comparable<CategoryHandle> {

	private String name;
	private String handle;
	private int num;
	private DimensionHandle dimension;
	private int apriori;
	// used for comparing categories, so that the same name in different
	// dimensions doesn't look like the same handle
	private String categoryID;
	
	public CategoryHandle(String name, String handle, int num, DimensionHandle dim, int count) {
		this.name = name;
		this.handle = handle;
		this.num = num;
		dimension = dim;
		apriori = count;
		categoryID = dim.getHandle()+":"+handle;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getHandle() {
		return handle;
	}
	
	public int getCategoryNum() {
		return num;
	}
	
	public int getCount() {
		return apriori;
	}
        
        public void setCount(int count){
            this.apriori = count;
        }
	
	public float getMarginalFrequency() {
		return (float)apriori/dimension.getDataSet().getNumRecords();
	}
	
	public DimensionHandle getDimension() {
		return dimension;
	}
	
	public int compareTo(CategoryHandle o) {
		return categoryID.compareTo(o.categoryID);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CategoryHandle)
			return compareTo((CategoryHandle)o) == 0;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		assert false : "hashCode not designed";
		return 42; // any arbitrary constant will do
	}
	
}
