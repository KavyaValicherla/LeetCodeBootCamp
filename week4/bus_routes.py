class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if source == target:
            return 0
        stop_to_bus = defaultdict(set)
        for i, route in enumerate(routes):
            for stop in route:
                stop_to_bus[stop].add(i)

        visited_buses = set()
        visited_stops = set([source])
        queue = deque([(source, 0)]) 

        
        while queue:
            current_stop, buses = queue.popleft()

           
            for bus in stop_to_bus[current_stop]:
                if bus in visited_buses:
                    continue  
                visited_buses.add(bus)

                for stop in routes[bus]:
                    if stop == target:
                        return buses + 1  
                    if stop not in visited_stops:
                        visited_stops.add(stop)
                        queue.append((stop, buses + 1))

        return -1

        