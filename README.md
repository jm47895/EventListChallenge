**Challenge Problem**

Retrieve data from a remote aws database and display it into a recylerview

**Challenge Solution**

Using MVVM architecture, I used Retrofit to display data from the amazon remote database into a recyclerview. In addition, the solution was built with the Observable pattern in mind and uses LiveData and Flow to track any 
changes. A cache was added for offline viewing and Retrofit updates the cache 
based on any changes found to the remote database.

**Challenege Improvement**

I noticed that the Venue data in the remote database was empty and 
returning null when retrieving so I didn't add that to the display and instead 
opted to display the photo, event name, and end date only based on the instructions.
  
I didn't really have time to implement tests given the time constraints but 
would have done so using Junit and Mockito.

I would have added pagenation so as not to call the data all at once, allowing for better performance and lower aws costs.  

As far as UI, I would have added a detail webview that would open the link to the event webpage. I opted for just mimicing the function by showing a snack bar that 
shows the url to the event. I also would change the colors based on the company template.  
