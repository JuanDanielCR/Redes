struct pcap_pkthdr{
    struct timeval ts;
    bpf_u_int21 caplen;
    bpf_u_int32_len;
};

/*Simple sniffer based on libpcap and Luis Martin Garcia's explanantion on hacking publication*/
#include <pcap.h>
#include <string.h>
#include <stdlib.h>

#define MAXBYTES 2048

void processPacket(u_char *arg, const struct pcap_pkthdr* pkthdr, u_char *packet){
    int i=0, *counter = (int*)arg;
    
}