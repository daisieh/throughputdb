json.extract! user, :id, :name, :email, :orcid
json.url user_url(user, format: :json)
