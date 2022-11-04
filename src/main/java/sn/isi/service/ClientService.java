package sn.isi.service;

import sn.isi.dto.ClientDto;

import java.util.List;

public interface ClientService {

    public ClientDto create(ClientDto clientDto);
    public ClientDto update(int id, ClientDto clientDto);
    public void remove(int id);
    public ClientDto get(int id);
    public List<ClientDto> getAll();
}
