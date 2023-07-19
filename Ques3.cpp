int calculateShortestPath(int numStops, vector<int> credits, int numRoads, vector<vector<int>> roads, int source, int dest)
{
    vector<vector<pair<int, int>>> adjacencyList(numStops);
    for (int i = 0; i < numRoads; i++) {
        int u = roads[i][0];
        int v = roads[i][1];
        int weight = roads[i][2];
        adjacencyList[u].push_back({v, weight});
        adjacencyList[v].push_back({u, weight});
    }
    vector<int> distances(1e6 + 5, 0x3f3f3f3f);
    priority_queue<pair<int, int>> pq;
    int initialNode = credits[source] * numStops + source;
    pq.push({0, initialNode});
    distances[initialNode] = 0;
    while (!pq.empty()) {
        auto currentPair = pq.top();
        int currentDistance = currentPair.first;
        int currentNode = currentPair.second;
        int currentCredit = currentNode / numStops;
        int currentVertex = currentNode % numStops;
        pq.pop();
        if (currentVertex == dest) {
            return -currentDistance;
        }
        for (auto neighbor : adjacencyList[currentVertex]) {
            int neighborVertex = neighbor.first;
            int weight = neighbor.second;
            if (weight > currentCredit) continue;
            int newCredit = currentCredit - weight + credits[neighborVertex];
            int newScore = newCredit * numStops + neighborVertex;
            if (newCredit > 1e4) continue;
            if (distances[newScore] > distances[currentNode] + weight) {
                distances[newScore] = distances[currentNode] + weight;
                pq.push({-(distances[currentNode] + weight), newScore});
            }
        }
    }
    return -1;
}


// 3rd working all verified