/*
 * S³ Platform API
 * This demo provides access to a limited set of features.   For more advanced capabilities, please contact us at our contact page - https://www.s-3.team/#contact-index  __Overview__  S³ Platform is a cloud-native cluster-based data storage solution. It implements number of sharding algorithms and strategies to achieve good performance and robustness. Before we begin with the user part, familiarize yourself with the following helpful terminology:  * <b>Key/Value Store</b> - Key/Value Store is a type of database system where data is stored and retrieved using unique keys associated with corresponding values. It provides a simple and efficient method for storing and accessing data, often used in applications requiring fast and flexible data storage solutions. * <b>Hash Map</b> - Hash Map is a data structure that stores key-value pairs and provides efficient retrieval of values based on their associated keys or object keys. It uses a hashing function to map keys to indexes, allowing for fast access to stored values. * <b>Sorted Set</b> - Sorted Set is a data structure similar to a set, but with the additional feature of maintaining the elements in sorted order based on a defined criterion, typically their scores or values. This structure enables efficient retrieval of elements in a specific order, making it useful for tasks like ranking or priority queues. * <b>Clustered Hash Map</b> - Clustered Hash Map is a distributed data structure that combines the features of a hash map with clustering capabilities, allowing it to span across multiple nodes in a cluster. This enables efficient storage and retrieval of key-value pairs while distributing the data load across the cluster for improved scalability and fault tolerance. * <b>Clustered Sorted Set</b> -  Clustered Sorted Set is a distributed data structure that combines the features of a sorted set with clustering capabilities, enabling it to span across multiple nodes in a cluster. This allows for efficient storage and retrieval of elements in sorted order while distributing the workload across the cluster for scalability and fault tolerance. * <b>Multi Index</b> - Multi Index is a data structure that allows for indexing of items based on multiple criteria simultaneously. It enables efficient querying and retrieval of items using various combinations of criteria, offering flexibility and optimization in data access for diverse applications. * <b>TimeSeries</b> - TimeSeries is a data structure optimized for storing and querying time-stamped data points or events in chronological order. It enables efficient retrieval, aggregation, and analysis of temporal data, making it ideal for applications such as monitoring, analytics, and trend analysis. * <b>BM25 Search</b> - BM25 (Best Matching 25) is a ranking function used in information retrieval to estimate the relevance of documents to a given search query. It's based on the probabilistic model of information retrieval, considering factors like term frequency and document length normalization. * <b>Regex Search</b> - Regex (Regular Expression) search involves using patterns to match text based on specific rules or sequences of characters. It allows for complex and flexible text searching and manipulation, enabling users to find and extract information efficiently based on customizable patterns. * <b>Auto Completion Search</b> - Auto Completion Search is a feature that predicts and suggests possible completions for a search query as the user types, based on existing data or patterns in the database. It enhances user experience by speeding up the search process and reducing typing effort, leading to more accurate and efficient results. * <b>Vector Search Storage</b> - Vector Search Storage organizes data as multi-dimensional vectors, enabling similarity-based searches that retrieve contextually relevant results. This technology enhances user experience by delivering more accurate, context-aware information, ideal for applications like recommendations and image searches. * <b>Vector Search Storage Worker</b> - Vector Search Workers are websocket-based processes designed to manage distributed vector search by processing queries across assigned data shards. Each worker receives and answers queries in real time, supporting various indexing methods: in-memory flat index for quick, direct access, HNSW for scalable approximate nearest neighbor search, SQLite-Vec for lightweight embedded database needs, and PG-Vector for relational data integration within Postgres. * <b>Distributed File Storage</b> - Distributed File Storage refers to a system architecture where files are stored across multiple storage nodes, rather than a single centralized server. This approach enhances scalability, fault tolerance, and performance by distributing the storage load across a network of interconnected nodes. * <b>Distributed Atomic Counters</b> - Distributed Atomic Counters are data structures used in distributed computing environments to maintain a shared counter value across multiple nodes while ensuring atomicity of operations. They enable concurrent increment and decrement operations across the distributed system without risking inconsistencies or race conditions. * <b>Distributed Locks</b> - Distributed locks are synchronization mechanisms used in distributed systems to coordinate access to shared resources among multiple nodes. They ensure mutual exclusion, allowing only one node at a time to access or modify a critical section of code or data, even in a distributed environment. * <b>Distributed Message Queue</b> - Distributed Message Queue (MQ) is a communication mechanism used in distributed systems to facilitate asynchronous messaging between different components or services. It enables decoupling of sender and receiver, allowing for scalable and fault-tolerant communication by storing messages temporarily until they are processed by the intended recipient. * <b>JWT (JSON Web Token)</b> - JSON Web Token (JWT) is a compact and self-contained mechanism for securely transmitting information between parties as a JSON object. It is commonly used for authentication and authorization in web applications, providing a digitally signed token that can be verified and trusted. * <b>RSA Public Private Key Pair</b> - RSA (Rivest-Shamir-Adleman) is a widely used asymmetric encryption algorithm that utilizes a pair of keys: a public key for encryption and a private key for decryption. Information encrypted with the public key can only be decrypted using the corresponding private key, ensuring secure communication and data integrity. * <b>User API Secret</b> - A User API Secret is a confidential authentication credential used to verify the identity of a user or application interacting with an API. It serves as a secure token, typically shared only between the user/application and the API provider, ensuring secure access to protected resources. * <b>Regex Based Permission Control</b> - Regex-based permission control is a method of managing access rights using regular expressions to define patterns for resource names or actions. It allows for flexible and granular permission assignment by matching user roles or permissions against predefined patterns, enabling precise control over access to specific resources or functionalities. * <b>Auto-Resharding</b> - Auto-resharding is an automated process used in distributed databases to dynamically adjust the partitioning of data across nodes in response to changes in the system's configuration or workload. It helps maintain balanced data distribution, optimize performance, and accommodate fluctuations in resource demand without manual intervention. * <b>Cursor Count Iteration</b> - Cursor count iteration method involves using a cursor to navigate through a dataset while also counting the number of items returned. It allows for efficient pagination and processing of large datasets by providing both the data and the total count of items, enabling streamlined navigation and analysis. * <b>Offset Limit Iteration</b> - Offset limit iteration method involves fetching a specific subset of data from a dataset by specifying an offset (starting point) and a limit (number of items to retrieve). It's commonly used for pagination in database queries, enabling efficient retrieval of data in chunks while controlling the amount of data returned in each query.  Synonyms:  * Entry and record are interchangeable. * Clustered datastructure and c-structure are interchangeable.  With the necessary knowledge at your disposal, you are ready to move forward.  __API Description__  The API includes the following capabilities and operations:  __Keys__  * Set, get and delete keys * Multiple set, get and delete keys * Scan, search and count keys  __Maps__  * Add, get and delete objects from maps * Multiple set, get and delete objects from maps * Scan, search and count objects from maps  __Sorted Sets__  * Add, get and delete objects from sorted sets * Multiple set, get and delete objects from sorted sets * Scan, search and count objects from sorted sets  __Clustered Maps__  * Add, get and delete objects from clustered maps * Multiple set, get and delete objects from clustered maps * Scan, search and count objects from clustered maps  __Clustered Sorted Sets__  * Add, get and delete objects from clustered sorted sets * Multiple set, get and delete objects from clustered sorted sets * Scan, search and count objects from sorted sets  __Multi-Index__  * Add, get and delete columns schema from multi-index * Insert, get and delete records from multi-index * Scan, search and count records from multi-index  __TimeSeries__  * Add, get and delete configurations from timeseries * Insert, get and delete entries, labels and metrics from timeseries * Scan, search and count entries, labels and metrics from timeseries  __Full Text Search__  * Add, get and delete indices from search storage * Insert, get and delete documents, phrases and bag of words from search storage * Search by bm25, regex and phrases from search storage  __Vector Search__  * Add, get and delete vectors from search storage * Add and remove workers from the index * Search KNN by vector  __File Storage__  * Add, get and delete buckets from file storage * Insert, get and delete file objects from file storage * List, count, scan buckets from file storage * List, count, scan file objects from file storage  __Atomic Counters__  * Increment, decrement, delete counters * Multiple increment, multiple decrement, mutliple delete counters * Set ttl for counters * Scan counters  __Distributed Locks__  * Lock, unlock, delete locks * Set ttl foc locks. * Check whether lock is locked or not * Scan locks  __Web Sockets__  * Connect and disconnect from websockets * Subscribe and unsubscribe from channels * Send and receive messages from channels * Unicast and broadcast sending modes  __Authentication__  * Create and get block users * Create, get, list, delete, block secrets * Issue, delete, expire JWT tokens  __Error Reporting__  * On success all methods return responses with HTTP status code 200 * On failure a non-200 status code is returned along with an ApiErr object. * For all responses 'X-Correlation-ID' header contains the correlation ID of the request.  The following resource collections are offered by this API:  * Keys - represents key value pairs storage abstraction * Maps - represents hash map storage abstraction * Sorted Sets - represents sorted set storage abstraction * Clustered Maps - represents c-structure hash map storage abstraction * Clustered Sorted Sets - represents c-structure sorted set storage abstraction * Multi Index - represents multiindex storage abstraction * Time Series - represents timeseries storage abstraction * Search - represents full text and regex search abstraction * Vector Search - represents vector search abstraction * File Storage - represents file storage abstraction * Atomic Counters - represents atomic counters abstraction * Distributed Locks - represents distributed locks abstraction * Distribuded Queues - represents distributed queues abstraction * Secrets - covers the creation and management of apps * Tokens - issue and revokation of new JWT objects  The following HTTP headers are used during the authentication process of the system:  * x-user - header containting the email address of the current user receiving permissions. Used when asking for permissions or access to user or app data. * x-state - current state of the OAuth2 authentication process. Used for retrieval of the user's public key and encryption of the nonce * x-nonce - unique token used during the OAuth2 authentication process. Used for retreiaval the JWT token and redirect url * x-secret - user's API secret. Used for access to the system. Generated by the platform. * x-token - JWT token generated by the platform. Contains permissions and access data to apps and users.  __Sample Authentication Flow__  Flow (OAuth2 flow): * User goes to App authentication page * App creates RSA Public/Private key pair for this user * App sends the public key to the platform and receives encrypted nonce * App put the nonce to the state of the OAuth2 authentication mechanism and starts authentication * OAuth2 provider authenticates and calls the platform * Platform uses the nonce to determine which is the user, find the redirect uri and returns it to the App together with JWT token * User uses the JWT token to access the platform data    
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: info@s-3.team
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.MITM142.client.api;

import com.google.gson.reflect.TypeToken;
import com.MITM142.client.*;
import com.MITM142.client.model.AtomicCountersRequestParams;
import com.MITM142.client.model.MultipleAtomicCountersRequestParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtomicCountersApi {
    private ApiClient localVarApiClient;

    public AtomicCountersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AtomicCountersApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for decr
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call decrCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/decr";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call decrValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling decr(Async)");
        }
        

        okhttp3.Call localVarCall = decrCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return Long
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public Long decr(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<Long> localVarResp = decrWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Long> decrWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = decrValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call decrAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<Long> _callback) throws ApiException {

        okhttp3.Call localVarCall = decrValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for decrBy
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call decrByCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/decr-by";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call decrByValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling decrBy(Async)");
        }
        

        okhttp3.Call localVarCall = decrByCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return Long
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public Long decrBy(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<Long> localVarResp = decrByWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Long> decrByWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = decrByValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Decrement atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call decrByAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<Long> _callback) throws ApiException {

        okhttp3.Call localVarCall = decrByValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for delCounter
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call delCounterCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/del-counter";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call delCounterValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling delCounter(Async)");
        }
        

        okhttp3.Call localVarCall = delCounterCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Delete counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public String delCounter(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<String> localVarResp = delCounterWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> delCounterWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = delCounterValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call delCounterAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = delCounterValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getCounter
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCounterCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/get-counter";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCounterValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling getCounter(Async)");
        }
        

        okhttp3.Call localVarCall = getCounterCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Return value of the counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return Long
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public Long getCounter(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<Long> localVarResp = getCounterWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Return value of the counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Long> getCounterWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = getCounterValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Return value of the counter by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCounterAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<Long> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCounterValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for incr
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call incrCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/incr";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call incrValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling incr(Async)");
        }
        

        okhttp3.Call localVarCall = incrCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return Long
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public Long incr(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<Long> localVarResp = incrWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Long> incrWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = incrValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: table, key       
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> New value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call incrAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<Long> _callback) throws ApiException {

        okhttp3.Call localVarCall = incrValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for incrBy
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call incrByCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/incr-by";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call incrByValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling incrBy(Async)");
        }
        

        okhttp3.Call localVarCall = incrByCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return Long
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public Long incrBy(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<Long> localVarResp = incrByWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Long> incrByWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = incrByValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Increment atomic counter for given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The new value of the counter. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call incrByAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<Long> _callback) throws ApiException {

        okhttp3.Call localVarCall = incrByValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<Long>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for multipleIncrSeparately
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of the new values for earch table, key pair accordingly. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call multipleIncrSeparatelyCall(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/multiple-incr-separately";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call multipleIncrSeparatelyValidateBeforeCall(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling multipleIncrSeparately(Async)");
        }
        

        okhttp3.Call localVarCall = multipleIncrSeparatelyCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Increment multiple atomic counters for given table and key. Counters will be incremented separetely&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of table,key pairs.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return List&lt;Long&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of the new values for earch table, key pair accordingly. </td><td>  -  </td></tr>
     </table>
     */
    public List<Long> multipleIncrSeparately(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<List<Long>> localVarResp = multipleIncrSeparatelyWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Increment multiple atomic counters for given table and key. Counters will be incremented separetely&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of table,key pairs.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;List&lt;Long&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of the new values for earch table, key pair accordingly. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Long>> multipleIncrSeparatelyWithHttpInfo(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = multipleIncrSeparatelyValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<List<Long>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Increment multiple atomic counters for given table and key. Counters will be incremented separetely&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of table,key pairs.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: All      
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of the new values for earch table, key pair accordingly. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call multipleIncrSeparatelyAsync(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<List<Long>> _callback) throws ApiException {

        okhttp3.Call localVarCall = multipleIncrSeparatelyValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<List<Long>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for multipleSetExpire
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call multipleSetExpireCall(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/multiple-set-expire";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call multipleSetExpireValidateBeforeCall(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling multipleSetExpire(Async)");
        }
        

        okhttp3.Call localVarCall = multipleSetExpireCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Delete multiple counters by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of counters for expire.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all  
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public String multipleSetExpire(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<String> localVarResp = multipleSetExpireWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete multiple counters by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of counters for expire.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all  
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> multipleSetExpireWithHttpInfo(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = multipleSetExpireValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete multiple counters by given table and key.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(N) where N is the number of counters for expire.&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all  
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call multipleSetExpireAsync(MultipleAtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = multipleSetExpireValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setExpire
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setExpireCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = params;

        // create path and map variables
        String localVarPath = "/counters/set-expire";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xAppUuid != null) {
            localVarHeaderParams.put("x-app-uuid", localVarApiClient.parameterToString(xAppUuid));
        }

        if (xSecret != null) {
            localVarHeaderParams.put("x-secret", localVarApiClient.parameterToString(xSecret));
        }

        if (xToken != null) {
            localVarHeaderParams.put("x-token", localVarApiClient.parameterToString(xToken));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setExpireValidateBeforeCall(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'params' is set
        if (params == null) {
            throw new ApiException("Missing the required parameter 'params' when calling setExpire(Async)");
        }
        

        okhttp3.Call localVarCall = setExpireCall(params, xAppUuid, xSecret, xToken, _callback);
        return localVarCall;

    }

    /**
     * 
     * Set expire ttl for counter.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all 
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public String setExpire(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        ApiResponse<String> localVarResp = setExpireWithHttpInfo(params, xAppUuid, xSecret, xToken);
        return localVarResp.getData();
    }

    /**
     * 
     * Set expire ttl for counter.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all 
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> setExpireWithHttpInfo(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken) throws ApiException {
        okhttp3.Call localVarCall = setExpireValidateBeforeCall(params, xAppUuid, xSecret, xToken, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Set expire ttl for counter.&lt;br&gt;&lt;br&gt; &lt;b&gt;Complexity&lt;/b&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;: O(1).&lt;br&gt; &lt;b&gt;Param Fields Used&lt;/b&gt;&amp;nbsp;: all 
     * @param params  (required)
     * @param xAppUuid  (optional)
     * @param xSecret  (optional)
     * @param xToken  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Empty string. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setExpireAsync(AtomicCountersRequestParams params, String xAppUuid, String xSecret, String xToken, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = setExpireValidateBeforeCall(params, xAppUuid, xSecret, xToken, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
